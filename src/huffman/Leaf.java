package huffman;

public class Leaf implements Comparable<Leaf> {
    private Character character;
    private int frequency = 0;

    private Leaf leftLeaf = null;
    private Leaf rightLeaf = null;

    //public Leaf (){};

    public Leaf (Character c){
        this.character = c;
        incrementFrequency();
    };

    public Leaf (Leaf left, Leaf right, Character c, int frequency){
        this.character = c;
        this.frequency = frequency;
        this.leftLeaf = left;
        this.rightLeaf = right;
    }


    public void incrementFrequency (){
        this.frequency++;
    }

    //getter and setter

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Leaf getLeftLeaf() {
        return leftLeaf;
    }

    public void setLeftLeaf(Leaf leftLeaf) {
        this.leftLeaf = leftLeaf;
    }

    public Leaf getRightLeaf() {
        return rightLeaf;
    }

    public void setRightLeaf(Leaf rightLeaf) {
        this.rightLeaf = rightLeaf;
    }

    // override equals and hashCode
    @Override
    public int compareTo(Leaf leaf) {
        return (this.frequency - leaf.getFrequency());
    }
}
