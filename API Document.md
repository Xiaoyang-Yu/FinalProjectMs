# Final Project Management System

SDK Version: 1.8v

## API Document

### BodyFatPercentage
The Form that the user to fill after Logining OR update
#### URL: /sys/bodyFatPercentage

#### Features
- ADD BodyFatPercentage 

- UPDATE BodyFatPercentage

- GET BodyFatPercentage BY ID

#### Database Information
|Field Name| Description|Type of data|explaination
|-| ------ |-|-|
|id|table id|```int```|PRIMARY KEY and AUTO_INCREMENT
|uid|user id|```int```| CURRENT LOGIN USER
|height|height|```int```|unit cm
|weight|weight|```int```|unit pound
|bfp|BFP|```int```|Body Fat Percentage
|bmi|BMI|```int```|Body Mass Index
|createTime|createTime|```datetime```|current time
|age|age|```int```|
|sex|sex|```int```| 0 FEMALE  1 MALE
#### Request Form

Dillinger is currently extended with the following plugins.
Instructions on how to use them in your own application are linked below.

|Function| URL | Method | Parameter | Respond |Explaination
|-| ------ | --- |----|-----|-|
|add| /bodyFatPercentage | POST|```{"uid":3, "height": 7, "weight": 100, "bfp": 10, "bmi":30, "age": 23, "sex": 0}```|```{"code":20000,"message":"Add Success!","data":{"id":1,"uid":3,"height":7,"weight":100,"bfp":10,"bmi":30,"createTime":null,"age":23,"sex":0}}```||
|update|/bodyFatPercentage | PUT |```{"id":3,"uid":3, "height": 7, "weight": 100, "bfp": 10, "bmi":30, "age": 23, "sex": 0}```|```{"code":20000,"message":"Update Success!","data":null}```|Must include "id"|
| getByID | /bodyFatPercentage/${id} |GET|id|```{"code":20000,"message":"success","data":{"id":1,"uid":3,"height":7,"weight":100,"bfp":10,"bmi":30,"createTime":[2023,9,9,15,17,14],"age":23,"sex":0}```}

