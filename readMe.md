table relationships
Normalization forms: 6 levels 

One to one
One to many
many to one
many to many

Employee details;:

EmpId, fName, lName, pn, email, address1, add2, city, province
, country postalcode, companyId, companyname, addr,..., salary
, title, SIN, DD details, instCode, typeOfEmployement, transit code,
acct number, car Info, ....n 

Employee Table: EmpId, fName, lName, pn, email, sinId
Address Table: AddrId, address1, add2, city, province
, country postalcode
one to one
SIN number: sin Id, addr id
one to many
Many to One
Employee-Address Table: EmpId, AddrId
                        5,      44
                        5,      43
                        5,      54
Company Table: companyId, companyname, AddrId
Project Table: ProjectId, scope, desc, budget, owner
course-Student table:
10,     123
10,     344
10,     543
11,     543
15,     543
20,     543

sevlets


Consuming APIs:
REST : Rest clients: HTTP clients

REST Template (Depricated)


Web Client (Recommanded)
Feign CLient (Netflix)

ResponseEntity, testing










