```toml
name = 'Update User'
method = 'PUT'
url = 'http://localhost:8080/api/users/'
sortWeight = 4000000
id = 'b3849746-53d9-4bf9-b50d-2ed36aa511e1'

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
