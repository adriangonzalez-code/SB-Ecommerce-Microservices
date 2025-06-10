```toml
name = 'Change Log Level'
method = 'POST'
url = 'http://localhost:8080/actuator/loggers/com.driagon'
sortWeight = 6000000
id = '8f0b7c7f-912e-4e39-acba-9430cc853900'

[body]
type = 'JSON'
raw = '''
{
  "configuredLevel": "DEBUG"
}'''
```
