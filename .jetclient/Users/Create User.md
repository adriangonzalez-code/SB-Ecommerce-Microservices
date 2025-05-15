```toml
name = 'Create User'
method = 'POST'
url = 'http://localhost:8080/api/users'
sortWeight = 2000000
id = '9cfd48be-f0d9-4e92-bb73-e276d9113bf8'

[body]
type = 'JSON'
raw = '''
{
  "firstName": "John", 
  "lastName": "Doe"
}'''
```
