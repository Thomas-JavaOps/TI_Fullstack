DROP TABLE IF EXISTS type_user;

CREATE TABLE type_user (
  id int(11) NOT NULL AUTO_INCREMENT,
  type varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  first_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  type_user_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (type_user_id) REFERENCES type_user(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
