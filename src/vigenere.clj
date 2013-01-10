(defn vigenere
   "This is a tool encrypt and decrypt string with vigenere algorithm"
   ([] (printUsage))
   ([option str cipher] 
      (case option:
	    "-e": println encrypt str cipher
		"-d": println decrypt str cipher
		printUsage)))
(defn printUsage
   "Print usage"
   []
   (println "aaa"))
(defn encrypt
   "encrypt string with vigenere algorithm"
   [srcStr cipher]
   ("sss"))
(defn decrypt
   "encrypt string with vigenere algorithm"
   [srcStr cipher]
   ("sss"))
