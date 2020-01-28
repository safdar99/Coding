Param(
	[Parameter(Mandatory=$true)]
	[String[]]
	$args
)
$programFile = $args[0]+".java"
$classFile = $args[0]
javac $programFile
java $classFile $args[1]