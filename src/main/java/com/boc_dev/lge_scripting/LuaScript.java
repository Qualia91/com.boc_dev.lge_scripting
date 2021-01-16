package com.boc_dev.lge_scripting;

import com.boc_dev.lge_model.gcs.Registry;
import com.boc_dev.lge_model.generated.components.ScriptObject;
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

	public void call(String script, ScriptObject scriptObject, Registry registry) {
		try {
			globals.set("registry", CoerceJavaToLua.coerce(registry));
			globals.set("script_object", CoerceJavaToLua.coerce(scriptObject));
			LuaValue chunk = globals.loadfile(scriptFolderLocation + "/" + script);
			chunk.call();
		} catch (Exception e) {
			// do nothing
			// todo: this is to fix a bug in idea. For some reason, --add-opens java.base/java.util=luaj.jse.modules isn't working.
		}
	}

}
