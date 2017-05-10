## Schema

/index/type/doc-id

* An index is a collection of documents that have somewhat similar characteristics.
* Within an index, you can define one or more types. A type is a logical category/partition of your index. In general, a type is defined for documents that have a set of common fields. 
* A document is a basic unit of information that can be indexed.

### Users

```
PUT
/users

POST
/users/user/b32f6cec-454c-44e1-971c-f4a38eb5ce9f
{
	"name" : "test-user"
	
}

```

### Devices

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

### Events
```
PUT
/events

POST
/events/aa7c1b06-b243-4f6a-9820-f2e0c12be170 (Device id as type)

{"en" : “TV ONFF event”, "ev" : “1”, "et" : 1000, "eu" : "ONOFF"}
{"en" : “TV ONFF event”, "ev" : “0”, "et" : 1001, "eu" : "ONOFF"}
{"en" : “TV ONFF event”, "ev" : “1”, "et" : 1002, "eu" : "ONOFF"}
{"en" : “TV power event”, "ev" : “100”, "et" : 1007, "eu" : “watts”}

POST
/devices/b32f6cec-454c-44e1-971c-f4a38eb5ce9f/788b1dd9-b005-46f6-b22a-c36ca589e1bb
{
  “name”: "Main Door",
  “desc”: "Main Door activity",
  “type”: "DoorSensor",
  "unit" : "ONOFF"
}

POST /devices/b32f6cec-454c-44e1-971c-f4a38eb5ce9f/6667254a-5581-4f06-9d4d-f3cd8a8c96be
{
  "name": "Back Door",
  "desc": "Back Door activity",
  "type": "DoorSensor",
  "unit" : "ONOFF"
}

```

### Charts

```
PUT
/charts

POST
/charts/b32f6cec-454c-44e1-971c-f4a38eb5ce9f (user id is type)
{
    "type" : "line",
    "resourceUrl" : "aa7c1b06-b243-4f6a-9820-f2e0c12be170",
    "etype" : "ONOFF",
    "color" : "#ff7f0e",
    "x": 
    {
      "attr": 
      {
        "name": "et",
        "type": "time",
        "label": "DateTime"
      },
      "interval": "dd"
    },
    "y": 
    {
      "attr": 
      {
        "name": "ev",
        "type": "number",
        "label": "ON-OFF"
      }
    }
}

POST /charts/b32f6cec-454c-44e1-971c-f4a38eb5ce9f
{
     "type": "state",
    "resourceUrl": "788b1dd9-b005-46f6-b22a-c36ca589e1bb",
    "etype" : "ONOFF",
    "color": "#2f4f4f",
    "x": {
      "attr": {
        "name": "timestamp",
        "type": "time",
        "label": "DateTime"
      },
      "interval": "ss"
    },
    "y": {
      "attr": {
        "name": "ev",
        "type": "number",
        "label": "Status"
      }
    }

}

POST /charts/b32f6cec-454c-44e1-971c-f4a38eb5ce9f
{
     "type": "state",
    "resourceUrl": "6667254a-5581-4f06-9d4d-f3cd8a8c96be",
    "etype" : "ONOFF",
    "color": "##ff7f0e",
    "x": {
      "attr": {
        "name": "timestamp",
        "type": "time",
        "label": "DateTime"
      },
      "interval": "ss"
    },
    "y": {
      "attr": {
        "name": "ev",
        "type": "number",
        "label": "Status"
      }
    }

}
```
## Search

```
https://search-smartelligyntes-zfnjlomb5dgk7gwbziwkvtkglq.us-west-2.es.amazonaws.com/events/_search
{
    "query": {
        "constant_score" : {
            "filter" : {
            	"bool" : {
            		"must" : [
            		
                         {"match" : { "_type" : "aa7c1b06-b243-4f6a-9820-f2e0c12be170" }} ,
                         {"match" : { "eu" : "ONOFF" }},
                         {
                         	"range" : 
                         	{
        							 "et" : 
        							 {
            							 "gte": "1002",
                						 "lte": "1003"
					                
        							 }
        					}
                         }
            		]
            	}
                 
            }
        }
    }
}
```
