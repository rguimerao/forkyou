# TODO
List of TODO things inside the project

Backend:
<ul>
	<li>Date type obsolete? - format</li>
	<li>Food - food is in dishes</li>
	<li>frontend controller checks food price >= 0 and not food - creating food</li>
	<li>review nickname user typing</li>
</ul>

Database:
<ul>
	<li>inserts - selects - updates - deletes</li>
	<li>select -> the same with return [refactor]</li>
	<li>Drinks cat -> to be already on db + func + insert script on sql ?</li>
	<li>get ratings</li>
	<li>Concurrent db interaction</li>
	<li>order db controller</li>
</ul>

Controllers:
<ul>
	<li>ratings done by frontend controller</li>
</ul>

Testing and code cleaning:
<ul>
	<li>tests - test classes</li>
	<li>design by contract</li>
	<li>identations - food, foodcreator, contactinfo, recipe, user, brand, appcontroller</li>
	<li>logger + comments</li>
	<li>sonarqube</li>
	<li>throws vs try catch - review, who should handle it?</li>
	<li>http://marketplace.eclipse.org/content/findbugs-eclipse-plugin</li>
	<li>http://marketplace.eclipse.org/content/pmd-eclipse</li>
</ul>

New features to add:
<ul>
	<li>Location → has opening hours</li>
	<li>Special ingredients</li>
	<li>A user can also buy food → long term</li>
	<li>Chat</li>
	<li>Rankings web page (json format)</li>
</ul>

Note: the app is online, not local, therefore, a lot of functionality is made online, that is to say, not only a lot, but all of it is made online with concurrent db interaction. With that in mind, the functionality of the backend must be reviewed.
