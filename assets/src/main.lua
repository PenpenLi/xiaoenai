
cc.FileUtils:getInstance():setPopupNotify(false)
cc.FileUtils:getInstance():addSearchPath("src/")
cc.FileUtils:getInstance():addSearchPath("res/")

local wishtree = "xiaoenai.wishtree.index"
local loverpets = "xiaoenai.lovepet.index"
local superbaby = "xiaoenai.superbaby.index"

if  gGameName == nil or gGameName == "" then
	-- gGameName = superbaby
	-- gGameName = wishtree
	--gGameName=  loverpets
end

local Config_Dict={
	[superbaby]="superbaby.config",
	[wishtree] ="config",
	[loverpets]="config",
}
local config_name=Config_Dict[gGameName] or "superbaby.config"
print("xiaoenai config_name" ,config_name)
require(config_name)
require "cocos.init"

local function main()
	print("hi, welcome to xiaoenai game !")
	print(" xiaoenai  gGameName" , gGameName)
	print(" xiaoenai  serveraddr:" , gGameServerAddr)
	print(" xiaoenai  token,secret,ts" ,gGmameToken ,gGmameSecret, gGameTs)
	if gGameName == loverpets then
		require("loverpets.MyApp"):create():run()
	elseif gGameName == wishtree then
		require("wishtree.MyApp"):create():run()
	elseif gGameName == superbaby then
		require("superbaby.MyApp"):create():run()
	else
		require("superbaby.MyApp"):create():run()
	end
end

 __G__TRACKBACK__ = function(msg)
       -- record the message
      local message = msg;
       -- auto genretated
      local msg = debug.traceback(msg, 3)
      print(msg)
      -- report lua exception
      -- buglyReportLuaException(tostring(message), debug.traceback())
      AccessToPlatform:getInstance():crashReport(msg)
      return msg
 end

local status, msg = xpcall(main, __G__TRACKBACK__)
if not status then
    print(msg)
    -- buglyReportLuaException(tostring(msg), debug.traceback())
    -- print("3333333")
end
