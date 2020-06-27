"# docker-rest-java-macaddress" 

1. get api-key from https://macaddress.io/api

2. build jdk8 + jar image from base
$docker image build -t jdk8-with-jar-image-from-dockerfile .

3. verify inside container
$docker container run -it jdk8-with-jar-image-from-dockerfile /bin/bash
/usr/local/bin# java -jar  CompanyLookupFromMacAddress.jar
Enter your macAddress: 44:38:39:ff:ef:57
Enter your apiKey:

Enter your apiKey: at_09XMnOnhkMuMAulsWw3wyGjf17cDu
{"vendorDetails":{"oui":"443839","isPrivate":false,"companyName":"Cumulus Networks, Inc","companyAddress":"650 Castro Street, suite 120-245 Mountain View CA 94041 US","countryCode":"US"},"blockDetails":{"blockFound":true,"borderLeft":"443839000000","borderRight":"443839FFFFFF","blockSize":16777216,"assignmentBlockSize":"MA-L","dateCreated":"2012-04-08","dateUpdated":"2015-09-27"},"macAddressDetails":{"searchTerm":"44:38:39:ff:ef:57","isValid":true,"virtualMachine":"Not detected","applications":["Multi-Chassis Link Aggregation (Cumulus Linux)"],"transmissionType":"unicast","administrationType":"UAA","wiresharkNotes":"No details","comment":""}}
companyName = Cumulus Networks, Inc

/usr/local/bin# exit

3. run container
$docker container run -it jdk8-with-jar-image-from-dockerfile
Enter your macAddress:
Enter your apiKey:

"# docker-rest-java-macaddress" 
