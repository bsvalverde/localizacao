const express = require("express");

const API_PORT = 3001
const app = express();
const router = express.Router();

const MongoClient = require('mongodb').MongoClient;
const assert = require('assert');

const url = 'mongodb://localhost:27017';
const databaseName = 'localizacao';
const client = new MongoClient(url, { useNewUrlParser: true });

const findDocuments = (db, collectionName, callback) => {
  const collection = db.collection(collectionName);
  collection.find({}).toArray((err, docs) => {
    assert.equal(err, null);
    console.log("Found the following records");
    console.log(docs);
    callback(docs);
  });
}

const connectAndFind = (collectionName, res) => {
  client.connect((err) => {
    assert.equal(null, err);
    console.log("Connected correctly to server");
    const database = client.db(databaseName);
    findDocuments(database, collectionName, (docs) => {
      client.close;
      return res.json({ [collectionName]: docs });
    });
  });
}

router.get("/getFuncionarios", (req, res) => {
  return connectAndFind('funcionarios', res);
});

router.get("/getLojas", (req, res) => {
  return connectAndFind('lojas', res);
});

router.get("/getFuncionarioLoja", (req, res) => {
  return connectAndFind('funcionario_loja', res);
});

app.use("/api", router);
app.listen(API_PORT, () => console.log(`LISTENING ON PORT ${API_PORT}`))