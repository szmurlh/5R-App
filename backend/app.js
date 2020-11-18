const express = require('express');
const app = express();
const mysql = require('mysql');
const zipcodes = require('zipcodes');

//gets all products in a subcategory
app.get('/product/:subcat', (req, res) => {
    console.log("Fetching for subcode " + req.params.subcat);
    const subcode = req.params.subcat;

    const connection = getConnection();

    var queryString = "SELECT producttable.productName, producttable.ID FROM producttable WHERE subCode = ?"
    connection.query(queryString, [subcode], (err, rows, fields,) => {
        if (err) {
            console.log("Failed to query database: " + err);
            res.sendStatus(500);
            return;
        }
        res.json(rows);
    });
});

//gets all information for a specific location
app.get('/location/:loc', (req, res) => {
    console.log("Fetching for location " + req.params.loc);
    const location = req.params.loc;

    const connection = getConnection();

    var queryString = "SELECT * FROM locations WHERE locID = ?"
    connection.query(queryString, [location], (err, rows, fields,) => {
        if (err) {
            console.log("Failed to query database: " + err);
            res.sendStatus(500);
            return;
        }
        res.json(rows);
    });
});

//gets locations based on id and radius
app.get('/:zip/:id', (req, res) => {
    console.log("Fetching for zip " + req.params.zip + " and ProductID " + req.params.id);
    const userzip = req.params.zip;
    const prodid = req.params.id;

    const connection = getConnection();
    const locRadius = 20; //adjust zip search radius here by miles
    var result = new Array(); //declare array for later use

    //get all locations from sql that accept product id
    var queryString = "SELECT locations.name, locations.locID, productmatch.prodID, locations.zip FROM locations RIGHT JOIN productmatch ON locations.locID = productmatch.locID WHERE productmatch.accepted = 1 AND productmatch.prodID = ?"
    connection.query(queryString, [prodid], (err, rows, fields,) => {
        if (err) {
            console.log("Failed to query database: " + err);
            res.sendStatus(500);
            return;
        }
        
        //filter locations by zip radius, push each location to array result
        rows.forEach(element => {
            var dist = zipcodes.distance(userzip, element.zip);
            if (dist < locRadius) {
                result.push(element);
            }
            else if (userzip == element.zip){ //fixes case where userzip is the same as location zip and the zipcode library returns nothing
                result.push(element);
            }
        });

        //res.json(rows[0].name); this format works

        //return result array, now filtered by product id and zip
        res.json(result)
    })


    /*
    queryString = "SELECT * FROM locations WHERE zip = ?"
    connection.query(queryString, [userzip], (err, rows, fields,) => {
        if (err) {
            console.log("Failed to query database: " + err);
            res.sendStatus(500);
            return;
        }
        console.log("Fetching job from mysql");


        //res.json(rows[0].name); this works
        res.json(rows)
    })*/
})

//test json get request
app.get("/user", (req, res) => {
    var user1 = {firstName: "Max", lastName:"Shaffer", zip: 13490}
    var user2 = {firstName: "Hannah", lastName:"Szmurlo", zip: 13440}
    res.json([user1,user2])
    console.log("Responding to /user")
})

app.get("/test", (req, res) => {
    console.log("Responding to test route");
    res.send("Hello from the 5R backend!")
})

//Starts backend server
app.listen(3001);
console.log("Backend listening on port 3001");

//Edit this function to change DB information
function getConnection(){
    return mysql.createConnection({
        host: 'localhost',
        user: 'badminano',
        password: 'testpw',
        database: '5rtestdb'
    })
}

//test json data if needed    https://jsonblob.com/api/5d1815da-02a9-11eb-9f82-2f0342b0cfd0