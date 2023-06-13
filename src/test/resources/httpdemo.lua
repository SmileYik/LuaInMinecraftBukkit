print("start.")

local httpdemo = {}

helper:toStringStringMap({ "a", "b" })

httpdemo.String = helper:getClass("java.lang.String")
httpdemo.URL = helper:getClass("java.net.URL")
httpdemo.BufferedReader = helper:getClass("java.io.BufferedReader")
httpdemo.HttpURLConnection = helper:getClass("java.net.HttpURLConnection")
httpdemo.InputStreamReader = helper:getClass("java.io.InputStreamReader")
httpdemo.Reader = helper:getClass("java.io.Reader")
httpdemo.InputStream = helper:getClass("java.io.InputStream")
-- httpdemo.newURL = httpdemo.URL:getDeclaredConstructor(helper:toArray(httpdemo.String, {httpdemo.String}))
-- httpdemo.newBufferedReader = httpdemo.BufferedReader:getDeclaredConstructor(helper:toArray(httpdemo.Reader, {httpdemo.Reader}))
-- httpdemo.newInputStreamReader = httpdemo.InputStreamReader:getDeclaredConstructor(helper:toArray(httpdemo.InputStream, {httpdemo.InputStream}))

function httpdemo.url(str)
    classes = helper:toArray(httpdemo.String, {httpdemo.String})
    args = helper:toStringArray({str})
    return helper:newInstance(httpdemo.URL, classes, args)
end

function httpdemo.get(str)
    url = httpdemo.url(str)
    con = url:openConnection()
    con:setRequestMethod("GET")
    is = con:getInputStream()

    classes = helper:toArray(httpdemo.InputStream, {httpdemo.InputStream})
    objs = helper:toObjectArray({is})
    isr = helper:newInstance(httpdemo.InputStreamReader, classes, objs)

    classes = helper:toArray(httpdemo.Reader, {httpdemo.Reader})
    objs = helper:toObjectArray({isr})
    br = helper:newInstance(httpdemo.BufferedReader, classes, objs)

    line = br:readLine()
    ret = ""
    while ( line ~= nil )
    do
        ret = ret .. "\n" .. line
        line = br:readLine()
    end
    br:close()
    return ret
end

print("load over")
local urlStr = "https://blog.smileyik.eu.org/blogs/other/all-albums.json"
ret = httpdemo.get(urlStr)
print("------ GET ------")
print(ret)
print("-----------------")