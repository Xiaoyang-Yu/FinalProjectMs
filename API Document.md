# FinalProjectMs
Final Project Management System

SDK Version: 1.8v

API Document

BodyFatPercentage（The Form that the user to fill after Logining）

Test URL: http://localhost:9999/sys/bodyFatPercentage

Features:

  add: 
      URL: /bodyFatPercentage
      method: POST 
      data: user
      EX. JOSN: {"uid":3, "height": 7, "weight": 100, "bfp": 10, "bmi":30, "bfpl": "30%", "age": 23, "sex": 0} *EXPLANATION: id and create_time is AUTO_INCREMENT
      respond: {
                "code": 20000,
                "message": "Add Success!",
                "data": {
                        "id": 1,
                        "uid": 3,           *user_id - CURRENT LOGIN USER
                        "height": 7,        *height - foot/inch
                        "weight": 100,      *weight - pound 
                        "bfp": 10,          *Body Fat Percentage(BFP)
                        "bmi": 30,          *Body Mass Index(BMI) - %
                        "createTime": null, *createTime
                        "age": 23,          *age
                        "sex": 0            *sex - 0 FEMALE  1 MALE
                        }
               }
  update:
      URL: /bodyFatPercentage
      method: PUT 
      data: user
      EX. JOSN: {"id":3,"uid":1, "height": 6, "weight": 200, "bfp": 20, "bmi":3, "age": 33, "sex": 1}  *EXPLANATION: id is necessary
      respond: {
                "code": 20000,
                "message": "Update Success!",
                "data": null
               }
               
  getbodyFatPercentageById
      URL: /bodyFatPercentage/${id}
      method: GET
      respond: {
    "code": 20000,
    "message": "success",
    "data": {
        "id": 1,
        "uid": 3,
        "height": 7,
        "weight": 100,
        "bfp": 10,
        "bmi": 30,
        "createTime": [2023,9,9,15,17,14],
        "age": 23,
        "sex": 0
    }
}
