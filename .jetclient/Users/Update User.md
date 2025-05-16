```toml
name = 'Update User'
method = 'PUT'
url = 'http://localhost:8080/api/users/1'
sortWeight = 4000000
id = '9536d25e-9f33-420b-b36a-e39863fcc444'

[body]
type = 'JSON'
raw = '''
{
  "firstName": "Juan",
  "lastName": "Perez",
  "email": "juan@mail.com",
  "phone": "1234567890",
  "address": {
    "street": "123 Main St",
    "city": "Springfield",
    "state": "IL",
    "country": "USA",
    "zipCode": "62701"
  }
}'''
```
