drop table if exists booking;

drop table if exists address;

create table address (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
line1 VARCHAR (250) NOT NULL,
line2 VARCHAR (250),
city  VARCHAR (100) NOT NULL,
state VARCHAR (100) NOT NULL,
country VARCHAR (100) NOT NULL,
zip_code INT NOT NULL
);

create table booking (
id INT AUTO_INCREMENT PRIMARY KEY,
transaction_guid UUID NOT NULL,
first_name VARCHAR(250) NOT NULL,
last_name VARCHAR(250) NOT NULL,
date_of_birth DATE NOT NULL,
checkin TIMESTAMP WITH TIME ZONE NOT NULL,
checkout TIMESTAMP WITH TIME ZONE NOT NULL,
total_price DOUBLE NOT NULL,
deposit DOUBLE NOT NULL,
address_id BIGINT UNIQUE NOT NULL,
CONSTRAINT FK_ADDRESS_ID foreign key (address_id) references address(id)
);

CREATE INDEX transaction_validator ON booking(transaction_guid);