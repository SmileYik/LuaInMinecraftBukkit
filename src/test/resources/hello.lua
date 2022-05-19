print("Hello!~~~~~")
local testClass = luajava.bindClass("tk.smileyik.Test1")
testClass:hello("I am lua!")
local instance = luajava.new(testClass)
instance:hello()
instance:hello2({a = 1, b = 2})
return {a = 1}