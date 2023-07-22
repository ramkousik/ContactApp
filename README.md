# ContactApp

Below are all the endpoints in the Contacts Application, along with the expected payload and response for each one:

POST /contacts** (Create a contact)

Endpoint: `/contacts`
Method: `POST`
Payload (Request Body):

  {
    "firstName": "kousik",
    "lastName": "ram",
    "email": "kousik.ram@email.com",
    "phoneNumbers": ["1234567890", "9876543210"]
  }

Response (201 Created):

  {
    "id": "contact_id",
    "firstName": "kousik",
    "lastName": "ram",
    "email": "kousik.ram@email.com",
    "phoneNumbers": ["1234567890", "9876543210"]
  }

GET /contacts/{contactId} (Get contact)

Endpoint: `/contacts/{contactId}`
Method: `GET`
Response (200 OK):

  {
    "id": "contact_id",
    "firstName": "kousik",
    "lastName": "ram",
    "email": "kousik.ram@email.com",
    "phoneNumbers": ["1234567890", "9876543210"]
  }


GET /contacts/search/name** (Search contacts by name)
Endpoint: `/contacts/search/name`
Method: `GET`
Query Parameter: `name` (string)
Response (200 OK):

  [
    {
      "id": "contact_id_1",
      "firstName": "ram",
      "lastName": "kousik",
      "email": "ramkousikallame@email.com",
      "phoneNumbers": ["1234567890", "9876543210"]
    },
    {
      "id": "contact_id_2",
      "firstName": "k",
      "lastName": "Smith",
      "email": "jane.smith@example.com",
      "phoneNumbers": ["1112223333"]
    }
  ]


GET /contacts/search/phonenumber (Search contacts by phone number)

Endpoint: `/contacts/search/phonenumber`
Method: `GET`
Query Parameter: `phonenumber` (string)
Response (200 OK):

  [
    {
      "id": "contact_id_1",
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "phoneNumbers": ["1234567890", "9876543210"]
    }
  ]


PUT /contacts/{contactId} (Update contact)

Endpoint: `/contacts/{contactId}`
Method: `PUT`
Payload (Request Body):
  
  {
    "firstName": "Updated John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "phoneNumbers": ["5555555555", "9876543210", "9999999999"]
  }

Response (200 OK):

  {
    "id": "contact_id",
    "firstName": "Updated John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "phoneNumbers": ["5555555555", "9876543210", "9999999999"]
  }

DELETE /contacts/{contactId} (Delete contact)

Endpoint: `/contacts/{contactId}`
Method: `DELETE`
Response (204 No Content) - Empty response with no body.


