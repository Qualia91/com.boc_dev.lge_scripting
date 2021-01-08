package com.boc_dev.lge_scripting;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class LuaScript {

	private final Globals globals;

	public LuaScript() {

		this.globals = JsePlatform.standardGlobals();

	}

	public void call(String scriptCode) {
		LuaValue chunk = globals.load(scriptCode);
		chunk.call();
	}

	public static void main(String[] args) {
		LuaScript luaScript = new LuaScript();
		luaScript.call("print(\"hello, world\")");
	}
}
