API URL and JSON format

### URL  : /users
### Payload :

```
{
  "emailId": "myemail@gmail.com",
  "name": "a user name",
  "timeZone": null,
  "location": "japan",
  "token": {
    "wink": [
      {
        "appName": "wink",
        "shortLivedToken": "SHORT-TOKEN",
        "refreshToken": "REF-TOKEN",
        "createdTime": "Sun Jun 18 18:42:22 PDT 2017",
        "expiryTime": "Sun Jun 18 18:42:22 PDT 2017",
        "lastAccessTime": "Sun Jun 18 18:42:22 PDT 2017",
        "appUserId": "winkuserid"
      },
      {
        "appName": "wink1",
        "shortLivedToken": "SHORT-TOKE-1",
        "refreshToken": "REF-TOKEN-1",
        "createdTime": "Sun Jun 18 18:42:22 PDT 2017",
        "expiryTime": "Sun Jun 18 18:42:22 PDT 2017",
        "lastAccessTime": "Sun Jun 18 18:42:22 PDT 2017",
        "appUserId": "winkuserid1"
      }
    ]
  }
}
```
