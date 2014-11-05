/*
    // Commutator
    public static SquareMatrix commutator(SquareMatrix a, SquareMatrix b) throws Exception {
        // Get a*b and b*a
        SquareMatrix ab = a.multiply(b);
        SquareMatrix ba = b.multiply(a);
        // Return new matrix of ab-ba
        return new SquareMatrix(SquareMatrix.subtract(ab,ba).matrixArray);
    }

 // Cast object to SquareMatrix
        final SquareMatrix beta = (SquareMatrix) b;

        // Check to see if size the same. Merely comparing matrixArrays variable did not work!
        if (this.matrixSize == beta.matrixSize) {
            // Loop through all elements
            for (int i = 0; i < this.matrixSize; i++) {
                for (int j = 0; j < this.matrixSize; j++) {
                    // If element does not match
                    if (this.matrixArray[i][j] != beta.matrixArray[i][j])
                        return false;

                }
            }
            // If all elements match
            return true;
        }

        // If all else fails:
        return false;
    }

// Equals
    public boolean equals(Object b) {

        // If either null
        if (this == null || b == null)
            return false;

        // If different object types
        if (this.getClass() != b.getClass())
            return false;

        // If same object
        if (this == b)
            return true;*/