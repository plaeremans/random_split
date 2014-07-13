# random-split

A Clojure library designed to randomly split a file, 
for example a csv file into two files according to a split factor

## Usage


The following commands will split the input file in two files, 
where the lines that end up in each file are determined at random.

When the split factor is 0.5 each file wil contain an equal number of lines, if the input file has an even number of data rows.

lein repl 
(use 'random-split.core)
(split-file "inputfile.csv" "f1" "f2" 0.5)


## License

Copyright © 2014 Pieter Laeremans

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
