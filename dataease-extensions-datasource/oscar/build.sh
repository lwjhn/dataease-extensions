#!/bin/sh
mvn clean package -U -Dmaven.test.skip=true

cp oscar-backend/target/oscar-backend-1.18.6.jar .

zip -r oscar.zip  ./oscar-backend-1.18.6.jar ./oscarDriver   ./plugin.json
