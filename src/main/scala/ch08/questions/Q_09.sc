//9. In the Creature class of Section 8.10, “Construction Order and Early Definitions,”
//   on page 94, replace val range with a def. What happens when you also use a
//   def in the Ant subclass? What happens when you use a val in the subclass?
//   Why?


// Creature | Ant | Creature {range / env.length}  | Ant {range / env.length}
// val      | val | 10 / 10                        | 2 / 0
// def      | val | 10 / 10                        | 2 / 0
// def      | def | 10 / 10                        | 2 / 2