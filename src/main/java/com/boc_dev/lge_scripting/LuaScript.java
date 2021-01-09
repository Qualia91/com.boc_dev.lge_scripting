package com.boc_dev.lge_scripting;

import com.boc_dev.lge_model.gcs.Registry;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

public class LuaScript {

	private final Globals globals;
	private final String scriptFolderLocation;

	public LuaScript(String scriptFolderLocation) {

		this.globals = JsePlatform.standardGlobals();
		this.scriptFolderLocation = scriptFolderLocation;

	}

	public void call(String script, Registry registry) {
		globals.set("registry", CoerceJavaToLua.coerce(registry));
		LuaValue chunk = globals.loadfile(scriptFolderLocation + "\\" + script);
		chunk.call();
	}

}
