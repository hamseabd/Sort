
class Sort
{

//  NODE. A node in a linear singly linked list of INTs.

  private static class Node
  {
    private int  number;  //  The INT in the node, duh.
    private Node next;    //  The NODE that follows this one, or NULL.

//  Constructor. Initialize a new NODE with NUMBER and NEXT.

    private Node(int number, Node next)
    {
      this.number = number;
      this.next = next;
    }
  }


//  MAKE NODES. Return a list of NODEs that contains INTs from NUMBERS in order
//  of their appearance.

  private static Node makeNodes(int ... numbers)
  {
    if (numbers.length > 0)
    {
      Node first = new Node(numbers[0], null);
      Node last  = first;
      for (int index = 1; index < numbers.length; index += 1)
      {
        last.next = new Node(numbers[index], null);
        last = last.next;
      }
      return first;
    }
    else
    {
      return null;
    }
  }

//  WRITE NODES. Write the INTs from a list of NODEs in paired square brackets,
//  separated by commas, with a newline at the end.

  private static void writeNodes(Node nodes)
  {
    System.out.print('[');
    if (nodes != null)
    {
      System.out.print(nodes.number);
      nodes = nodes.next;
      while (nodes != null)
      {
        System.out.print(", ");
        System.out.print(nodes.number);
        nodes = nodes.next;
      }
    }
    System.out.println(']');
  }

//  SORT NODES. Sort UNSORTED, a list of NODEs, into nondecreasing order of its
//  NUMBER slots, without making new NODEs.

  private static Node sortNodes(Node unsorted)
  {
    Node left = null;
    Node right = null;
    Node temp = null;
    boolean odd = false;

    if(unsorted == null || unsorted.next == null)
    {
      return unsorted;
    }
    else
    {
      while(unsorted !=  null)
      {
        if(odd)
        {
          temp = unsorted.next;
          unsorted.next = left;
          left = unsorted;
          unsorted = temp;
        }
        else
        {
          temp = unsorted.next;
          unsorted.next = right;
          right = unsorted;
          unsorted = temp;
        }
        odd = !odd;
      }
    }

      left = sortNodes(left);
      right = sortNodes(right);

      Node head = null;
      Node sorted = null;


      if(left.number <= right.number)
      {
        sorted = left;
        head = left;
        left = left.next;
      }
      else
      {
        sorted = right;
        head = right;
        right = right.next;
      }

      while(left!= null && right != null)
      {
        if(left.number <= right.number)
        {
          sorted.next = left;
          sorted = sorted.next;
          left = left.next;
        }
        else
        {
          sorted.next = right;
          sorted = sorted.next;
          right = right.next;
        }
      }
        if(left == null)
        {
          sorted.next = right;
        }
        else
        {
          sorted.next = left;
        }

      return head;
    }


}
