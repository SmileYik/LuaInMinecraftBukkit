
### isLoadPlugin
+ **Description**:  指定脚本插件是否加载.
+ **Return Type**: **boolean**
+ **Return Desc**: 如果已经加载则返回true.
+ **Usage**: `isLoadPlugin(id:String)`

|Name|Type|Description|
|-|-|-|
|id|**String**|脚本插件id|
### newLuaRunnable
+ **Description**:  以指定id对应的函数为run方法主体创建一个Runnable子类实例
+ **Return Type**: **LuaRunnable**
+ **Return Desc**: LuaRunnable实例
+ **Usage**: `newLuaRunnable(id:String)`

|Name|Type|Description|
|-|-|-|
|id|**String**|函数路径|
### newLuaRunnable
+ **Description**:  以指定id对应的函数为run方法主体创建一个Runnable子类实例
+ **Return Type**: **LuaRunnable**
+ **Return Desc**: LuaRunnable实例
+ **Usage**: `newLuaRunnable(id:String, obj:Object)`

|Name|Type|Description|
|-|-|-|
|id|**String**|函数路径|
|obj|**Object**|带入的参数.|
### getPlugin
+ **Description**:  获取本插件实例对象.
+ **Return Type**: **Plugin**
+ **Return Desc**: 本插件的实例对象.
+ **Usage**: `getPlugin()`

|Name|Type|Description|
|-|-|-|

### isNativeMode
+ **Description**:  插件是否在Native模式下运行.
+ **Return Type**: **boolean**
+ **Return Desc**: 如果是在Native模式下运行则返回true.
+ **Usage**: `isNativeMode()`

|Name|Type|Description|
|-|-|-|

### httpAction
+ **Description**:  以插件身份发送一个HTTP请求.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `httpAction(plugin:LuaPlugin, urlString:String, body:byte[], preOperation:Object, callback:Object, errorCallback:Object)`

|Name|Type|Description|
|-|-|-|
|plugin|**LuaPlugin**|Lua插件实例.|
|urlString|**String**|链接字符串|
|body|**byte[]**|请求体，如果传入null则代表不需要请求体.|
|preOperation|**Object**|前置操作Lua函数闭包，将会传入一个HttpURLConnection实例给闭包.|
|callback|**Object**|一个Lua函数闭包，会将ResponseCode以及HTTP请求的文本结果作为字符串传递给闭包.|
|errorCallback|**Object**|一个Lua函数闭包，其只在运行过程中出现错误时调用，会将Exception实例传给闭包.|
### httpAction
+ **Description**:  以插件身份发送一个HTTP请求.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `httpAction(plugin:LuaPlugin, urlString:String, method:String, body:byte[], connectTimeout:int, readTimeout:int, instanceFollowRedirects:boolean, Map<String:, header:String>, useCaches:boolean, callback:Object, errorCallback:Object)`

|Name|Type|Description|
|-|-|-|
|plugin|**LuaPlugin**|Lua插件实例.|
|urlString|**String**|链接字符串|
|method|**String**|请求方法|
|body|**byte[]**|请求体，如果传入null则代表不需要请求体.|
|connectTimeout|**int**|连接等待时间(毫秒).|
|readTimeout|**int**|读取等待时间(毫秒).|
|instanceFollowRedirects|**boolean**|是否跟随重定向.|
|Map<String|****|null|
|header|**String>**|需要添加的请求头，为null则代表不需要添加.|
|useCaches|**boolean**|是否使用缓存.|
|callback|**Object**|一个Lua函数闭包，会将ResponseCode以及HTTP请求的文本结果作为字符串传递给闭包.|
|errorCallback|**Object**|一个Lua函数闭包，其只在运行过程中出现错误时调用，会将Exception实例传给闭包.|
### httpAction
+ **Description**:  以插件身份发送一个HTTP请求.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `httpAction(plugin:LuaPlugin, urlString:String, method:String, body:String, bodyEncode:String, connectTimeout:int, readTimeout:int, instanceFollowRedirects:boolean, Map<String:, header:String>, useCaches:boolean, callback:Object, errorCallback:Object)`

|Name|Type|Description|
|-|-|-|
|plugin|**LuaPlugin**|Lua插件实例.|
|urlString|**String**|链接字符串|
|method|**String**|请求方法|
|body|**String**|字符串请求体，如果传入null则代表不需要请求体.|
|bodyEncode|**String**|字符串请求体编码格式.|
|connectTimeout|**int**|连接等待时间(毫秒).|
|readTimeout|**int**|读取等待时间(毫秒).|
|instanceFollowRedirects|**boolean**|是否跟随重定向.|
|Map<String|****|null|
|header|**String>**|需要添加的请求头，为null则代表不需要添加.|
|useCaches|**boolean**|是否使用缓存.|
|callback|**Object**|一个Lua函数闭包，会将ResponseCode以及HTTP请求的文本结果作为字符串传递给闭包.|
|errorCallback|**Object**|一个Lua函数闭包，其只在运行过程中出现错误时调用，会将Exception实例传给闭包.|
### httpGet
+ **Description**:  以插件身份发送一个HTTP的GET请求.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `httpGet(plugin:LuaPlugin, urlString:String, connectTimeout:int, readTimeout:int, instanceFollowRedirects:boolean, Map<String:, header:String>, useCaches:boolean, callback:Object, errorCallback:Object)`

|Name|Type|Description|
|-|-|-|
|plugin|**LuaPlugin**|Lua插件实例.|
|urlString|**String**|链接字符串|
|connectTimeout|**int**|连接等待时间(毫秒).|
|readTimeout|**int**|读取等待时间(毫秒).|
|instanceFollowRedirects|**boolean**|是否跟随重定向.|
|Map<String|****|null|
|header|**String>**|需要添加的请求头，为null则代表不需要添加.|
|useCaches|**boolean**|是否使用缓存.|
|callback|**Object**|一个Lua函数闭包，会将ResponseCode以及HTTP请求的文本结果作为字符串传递给闭包.|
|errorCallback|**Object**|一个Lua函数闭包，其只在运行过程中出现错误时调用，会将Exception实例传给闭包.|
### httpGet
+ **Description**:  以插件身份发送一个HTTP的GET请求.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `httpGet(plugin:LuaPlugin, urlString:String, connectTimeout:int, readTimeout:int, instanceFollowRedirects:boolean, useCaches:boolean, callback:Object, errorCallback:Object)`

|Name|Type|Description|
|-|-|-|
|plugin|**LuaPlugin**|Lua插件实例.|
|urlString|**String**|链接字符串|
|connectTimeout|**int**|连接等待时间(毫秒).|
|readTimeout|**int**|读取等待时间(毫秒).|
|instanceFollowRedirects|**boolean**|是否跟随重定向.|
|useCaches|**boolean**|是否使用缓存.|
|callback|**Object**|一个Lua函数闭包，会将ResponseCode以及HTTP请求的文本结果作为字符串传递给闭包.|
|errorCallback|**Object**|一个Lua函数闭包，其只在运行过程中出现错误时调用，会将Exception实例传给闭包.|