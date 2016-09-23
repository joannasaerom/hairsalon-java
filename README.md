# _Hair Salon Website_

#### _Allows hair salong to keep track of stylists and clients._

#### By _**Joanna Anderson**_

## Description

_This application is a customized hair salon website that allows employers to easily keep track of all their hair stylists and clients. Employers have the ability to add, update, and delete new hair stylists and clients.._

## Installation Requirements

1. Go to [my GitHub](https://github.com/jsaerom/hairsalon-java)
2. Click Clone or download and choose either the Open in Desktop option or Download Zip option
**OR**
1. Open Terminal
2. Command $ git clone https://github.com/jsaerom/hairsalon-java

In PSQL:
1. CREATE DATABASE hair_salon;
2. CREATE TABLE stylists (id serial PRIMARY KEY, name varchar, phone varchar, img_url varchar, email varchar, bio varchar, instagram varchar, specialty varchar, days varchar);
3. CREATE TABLE clients (id serial PRIMARY KEY, name varchar, phone varchar, email varchar, next_appt timestamp, img_url varchar, stylistId int);
4. Run the following command: $ psql media < media.sql

## Technologies Used

* _Java_
* _Spark_
* _HTML_
* _Velocity Template Engine_
* _CSS_
* _Bootstrap_

### License

Copyright (c) 2016 **_Joanna Anderson_**
