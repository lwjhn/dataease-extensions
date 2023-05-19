#!/bin/sh
mvn clean package

cp trino-backend/target/trino-backend-1.18.0.jar .

zip -r trino.zip  ./trino-backend-1.18.0.jar ./trinoDriver   ./plugin.json
