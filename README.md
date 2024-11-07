# spring-boot-digital-ocean-space

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-digital-ocean-space.git`
2. Navigate to the folder: `cd spring-boot-digital-ocean-space`
3. Change DO Space Credentials in `application.yml`
4. Run the application: `mvn clean spring-boot:run`
5. Open POSTMAN App then import POSTMAN collection file
6. Hit the API

### Image Screen shot

Upload new Image

```shell
curl --location 'http://localhost:8080/upload/new' \
--form 'file=@"oukTU-vac/loker.png"'
```

![Upload new Image](img/upload.png "Upload new Image")

List All images

```shell
curl --location 'http://localhost:8080/upload/list'
```

![List All images](img/list.png "List All images")

Delete Image by filename

```shell
curl --location --request DELETE 'http://localhost:8080/upload/delete/loker.png'
```
![Delete Image by filename](img/delete.png "Delete Image by filename")
