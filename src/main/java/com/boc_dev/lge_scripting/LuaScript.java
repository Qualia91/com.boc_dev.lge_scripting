package com.boc_dev.lge_scripting;

import com.boc_dev.lge_model.gcs.Registry;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

public class LuaScript {

	private final Globals globals;

	public LuaScript() {

		this.globals = JsePlatform.standardGlobals();

	}

	public void call(String scriptCode, Registry registry) {
		globals.set("registry", CoerceJavaToLua.coerce(registry));
		LuaValue chunk = globals.load(scriptCode);
		chunk.call();
	}

}
