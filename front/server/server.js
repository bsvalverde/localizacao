const express = require("express");

const API_PORT = 3001
const app = express();
const router = express.Router();

//
// const MongoClient = require('mongodb').MongoClient;
// const assert = require('assert');

// // Connection URL
// const url = 'mongodb://localhost:27017';

// // Database Name
// const dbName = 'localizacao';

// // Create a new MongoClient
// const client = new MongoClient(url, { useNewUrlParser: true });

// // Use connect method to connect to the Server
// client.connect(function(err) {
//   assert.equal(null, err);
//   console.log("Connected successfully to server");

//   const db = client.db(dbName);

//   client.close();
// });

router.get("/get", (req, res) => {
  return res.json({ msg: 'sucesso' })
});

app.use("/api", router);
app.listen(API_PORT, () => console.log(`LISTENING ON PORT ${API_PORT}`))