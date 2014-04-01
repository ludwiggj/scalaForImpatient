package sec02 {
package com {
  package horstmann {
    package impatient {
      class Manager {
        // The following doesn't work. It gives the following error:

        // object mutable is not a member of package sec02.com.horstmann.collection
        //        val subordinates = new collection.mutable.ArrayBuffer[Employee]

//        val subordinates = new collection.mutable.ArrayBuffer[Employee]
        val subordinates = new _root_.scala.collection.mutable.ArrayBuffer[Employee]
        def description = "A manager with " + subordinates.length + " subordinates"
      }
    }
  }
}
}

package sec02 {
package com {
  package horstmann {
    package collection {
      // This is a dummy package to demonstrate issue when using relative package names
      // Any reference to collection.<package_name.<etc_> will resolve to this package
    }
  }
}
}