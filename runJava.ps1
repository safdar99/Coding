Param(
	[Parameter(Mandatory=$true)]
	[String[]]
	$args
)
$classpath = ".\;C:\Users\safda\Coding"
$programFile = $args[0]+".java"
$classFile = $args[0]
javac -cp $classpath $programFile
java -cp $classpath $classFile