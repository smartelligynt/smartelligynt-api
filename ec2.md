* Login from terminal

```
ssh -o "StrictHostKeyChecking no" -i "aws-ec2.pem" ec2-user@52.26.71.168
docker pull smartelligynt/smartelligynt-app

docker run -d -p 8082:3000 smartelligynt/smartelligynt-app

cd /etc/nginx

sudo vi nginx.conf


location /console {
                proxy_pass http://127.0.0.1:8082;
        }  

sudo nginx -s reload
```

