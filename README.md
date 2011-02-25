# Description
This project holds the source code for any public post written in forrst.com by
[Markos Charatzas][1]

Since 'code' posts need to be more focused the source code provides a broader
context as well as allows anyone to navigate through it and even reuse it.

# Licence
All code is distributed under the Attribution-ShareAlike 3.0 Unported 
(CC BY-SA 3.0) [licence][2] and an attribution must be provided with a link to 
the original forrst post as defined by the package structure or mentioned as a 
comment in the source file if the former isn't applicable.

The package structure is defined as follows: 

1. com.forrst  : as the forrst domain
2. java        : the tag under which the code is
3. t           : t for '~' followed by the short URL of the post

Therefore for all the source code under the package

    *com.forrst.java.t1Jc*
    
you can find the post at

    *http://forrst.com/~1Jc*
    
which can be used as the URL for reference.

# Usage
The project is [mavenized][3] and IDE independent thus you can easily make a jar

    *mvn package*
    
any dependencies are also listed in the pom.xml

[1]: http://forrst.me/Cue
[3]: http://maven.apache.org/
[2]: http://creativecommons.org/licenses/by-sa/3.0/
