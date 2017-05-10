##Schema##
/index/type/doc-id

* An index is a collection of documents that have somewhat similar characteristics.
* Within an index, you can define one or more types. A type is a logical category/partition of your index. In general, a type is defined for documents that have a set of common fields. 
* A document is a basic unit of information that can be indexed.

###Users###
```
PUT
/users

POST
/users/user/b32f6cec-454c-44e1-971c-f4a38eb5ce9f
{
	"name" : "test-user"
	
}

```

###Devices###
```
PUT
/devices

POST
/devices/b32f6cec-454c-44e1-971c-f4a38eb5ce9f/aa7c1b06-b243-4f6a-9820-f2e0c12be170 (user id is type )
{
  "name" : "TV Switch",
  "desc" : "Family room TV",
  "type" : "smartSwitch",
  "unit" : "ONOFF"
}
```

