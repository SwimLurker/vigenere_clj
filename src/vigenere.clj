(defn printUsage
  "Print usage"
  []
  (println "Usage: vigenere -e <srouce string> <cipher> //Encrypt source string with the cipher by vigenere algorithm;")
  (println "       vigenere -d <encrypted string> <cipher> //Decrypt encrypted string with the cipher by vigenere algorithm;"))

(defn isUpperLetter
  [c]
  (if (and (>= (int c) (int \A)) (<= (int c) (int \Z))) true false))

(defn encryptChar
  [srcChar cipherChar]
  (char (+ (rem (+ (- (int srcChar) (int \A)) (- (int cipherChar) (int \A))) 26) (int \A))))

(defn enryptInternal
  [srcStr cipherRemain cipher]
  (if (= cipherRemain "") (enryptInternal srcStr cipher cipher)
    (if (= srcStr "") ""
      (let [sc (Character/toUpperCase (nth srcStr 0)) cc (Character/toUpperCase (nth cipherRemain 0))]
        (if-not (isUpperLetter sc)
            (str " " (enryptInternal (subs srcStr 1) cipherRemain cipher))
            (str (encryptChar sc cc) (enryptInternal (subs srcStr 1) (subs cipherRemain 1) cipher)))))))

(defn encrypt
  "encrypt string with vigenere algorithm"
  [srcStr cipher] (enryptInternal srcStr cipher cipher))

(defn decryptChar
  [encChar cipherChar]
  (char (+ (rem (- (+ (int encChar) 26) (int cipherChar)) 26) (int \A))))

(defn deryptInternal
  [encStr cipherRemain cipher]
  (if (= cipherRemain "") (deryptInternal encStr cipher cipher)
    (if (= encStr "") ""
      (let [ec (Character/toUpperCase (nth encStr 0)) cc (Character/toUpperCase (nth cipherRemain 0))]
        (if-not (isUpperLetter ec)
          (str " " (deryptInternal (subs encStr 1) cipherRemain cipher))
          (str (decryptChar ec cc) (deryptInternal (subs encStr 1) (subs cipherRemain 1) cipher)))))))

(defn decrypt
  "decrypt string with vigenere algorithm"
  [encStr cipher] (deryptInternal encStr cipher cipher))

(defn vigenere
   "This is a tool encrypt and decrypt string with vigenere algorithm"
   ([] (printUsage))
   ([option strs cipher]
     (case option
         "-e" (println (encrypt strs cipher))
         "-d" (println (decrypt strs cipher))
         (printUsage))))

