define(["core/FlxState"], function(FlxState) {
	
	function Application(name, author, icon) {
		this.name = name;
		this.author = author;
		this.icon = icon;
	}
	
	Application.prototype.destroy = function() {
		console.log("WARNING: DESTROY IS NOT IMPLEMENTED!!!");
	};
	
	/**
	 * Retrieve and dom-insert the html fragment that's associated
	 * with this app, destroy (unwire) the
	 * previous app and call renderState() on the new one
	 */
	Application.prototype.render = function(state) {
		console.log("Application.render: showing up application " + this.name);
		$("#"+this.name+"MenuButton").button('toggle');
		if (state==="last")
			state = FlxState.getState(this.name);
		that = this;
		console.log("Application.render: state=" + state);
		var nextAppId = this.name + "-app",
			nextAppDiv = $("#"+nextAppId);
		var noApp = $(".application").length==0;
		var appChanged = $(".application").length>0
			&& $(".application.active").length>0
			&& $(".application.active").attr("id")!=nextAppId;
		if ( noApp || appChanged) {
			if (typeof(App.activeApp)!="undefined")
				App.activeApp.destroy();
			if (appChanged) {
				var currentAppDiv = $(".application.active");
				currentAppDiv.removeClass("active");
				currentAppDiv.addClass("dormant");
			}
			if (nextAppDiv.length==0) {
				console.log(nextAppId + " is not yet loaded...");
				console.log("-> loading app " + this.name);
				require([ "text!applications/"+ this.name + "/template.html"], function(html) {
					console.log("loaded application template");
					
					html = "<div class=\"application active\" id=\"" + nextAppId + "\">"
						 + html + "</div>";
					
					$("#applications").append(html);
					
					App.activeApp = App.apps[that.name];
					App.activeApp.renderState(state, true);
					App.activeApp.setup();
				});
			} else {
				console.log("using cached application dom");
				nextAppDiv.removeClass("dormant");
				nextAppDiv.addClass("active");
			}
		} else {
			console.log("Application.Render: app is already loaded");
			this.renderState(state, true);
		}
	};
	
	Application.prototype.saveState = function() {
		console.log("WARNING: SAVE STATE IS NOT IMPLEMENTED");
	};

	/**
	 * Bind controls for intra-app interaction. This is called by the
	 * render function, when the app's template is loaded
	 * and dom-inserted
	 */
	Application.prototype.setup = function() {
		console.log("WARNING: SETUP IS NOT IMPLEMENTED");
	};
	
	Application.prototype.renderState = function(state) {
		console.log("WARNING: RENDERSTATE IS NOT IMPLEMENTED!!!");
	};

	return Application;
	
});