# Reproduce bug in JDK XSLT Transformer

And exception "SAXException: Invalid UTF-16 surrogate detected: d83c ?" 

When being processed, XML stream is split by chunks of 1024 bytes  
If a multi-char symbol (e.g. emoji) is on the edge between two chunks then the first chunk is ended with the first char of the symbol and the second chunk is started with the second char of the symbol.  
In the given example we have a "fallen leaf" Unicode symbol (https://www.compart.com/en/unicode/U+1F342). In the UTF-16 representation it consists of two chars - 0xD83C and 0xDF42. When the second char is carried to the next chunk the first char 0xD83C is recognized as a single invalid character	
