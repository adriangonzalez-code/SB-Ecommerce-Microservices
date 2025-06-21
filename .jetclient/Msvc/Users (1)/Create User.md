```toml
name = 'Create User'
method = 'POST'
url = 'http://localhost:8081/api/users'
sortWeight = 2000000
id = 'f879ec50-7fff-4168-a0a1-3c6061933d90'

[body]
type = 'JSON'
raw = '''
{
  "firstName": "John", 
  "lastName": "Doe",
  "email": "mail@mail.com", 
  "phone": "1234567890",
  "address": {
    "street": "123 Main St",
    "city": "Anytown",
    "state": "CA",
    "country": "USA",
    "zipCode": "12345"
  },
}'''
```
