module LuaInMinecraftBukkit.main {
    requires java.base;
    requires org.luaj;
    requires org.bukkit;
    requires java.logging;
    requires java.net.http;

    opens org.keplerproject.luajava to java.base;
}