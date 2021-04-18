# sofa-sb


```shell script
curl -XGET -H "Content-Type:application/json" "http://localhost:8081/data-union/v1/1004/storeCode/2019-11-12/date/activeMembers"
```


#### upload file

```shell script
curl -XPOST -H "Content-Type:multipart/form-data" -F "file=@/Users/tank198435163.com/hello.txt" "http://localhost:8081/data-union/v1/upload/file"  -F "name=lisi" 
```

#### download file

```shell script
curl -XGET  "http://localhost:8081/data-union/v1/download/file/hello.txt" --output test.txt
```
