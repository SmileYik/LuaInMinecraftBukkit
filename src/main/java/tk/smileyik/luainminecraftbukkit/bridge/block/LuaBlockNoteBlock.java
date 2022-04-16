package tk.smileyik.luainminecraftbukkit.bridge.block;

import org.bukkit.block.NoteBlock;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

public class LuaBlockNoteBlock {
  // TODO org.bukkit.block.NoteBlock START
  @Deprecated
  public byte getRawNote(LuaValue location) {
    NoteBlock block = (NoteBlock) LuaValueHelper.toBlock(location).getState();
    return block.getRawNote();
  }

//  public void setNote(LuaValue location, org.bukkit.Note arg0) {
//    NoteBlock block = (NoteBlock) LuaValueHelper.toBlock(location).getState();
//    return block.setNote();
//  }

  @Deprecated
  public void setRawNote(LuaValue location, byte note) {
    NoteBlock block = (NoteBlock) LuaValueHelper.toBlock(location).getState();
    block.setRawNote(note);
  }

//  public org.bukkit.Note getNote(LuaValue location) {
//    NoteBlock block = (NoteBlock) LuaValueHelper.toBlock(location).getState();
//    return block.getNote();
//  }

  public boolean play(LuaValue location) {
    NoteBlock block = (NoteBlock) LuaValueHelper.toBlock(location).getState();
    return block.play();
  }

  @Deprecated
  public boolean play(LuaValue location, byte arg0, byte arg1) {
    NoteBlock block = (NoteBlock) LuaValueHelper.toBlock(location).getState();
    return block.play(arg0, arg1);
  }

//  public boolean play(LuaValue location, String instrument, org.bukkit.Note arg1) {
//    NoteBlock block = (NoteBlock) LuaValueHelper.toBlock(location).getState();
//    return block.play();
//  }


  // TODO org.bukkit.block.NoteBlock END
}
