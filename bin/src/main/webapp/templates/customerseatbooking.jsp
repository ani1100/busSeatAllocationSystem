<div data-ng-controller="customerSeatBookingController">
<div style="background-color:#e7feff;" class="container">
  <h2 class="d-flex justify-content-center">Customer Seat Booking</h2><br><br>
  <form>
	  <table>
		  <tbody>
			  <tr>
			      <td style="width:5%"></td>
				  <td style="width:10%">
				   <div class="form-group">
				      <label for="startloc">Start Location</label>
				      <input type="text" class="form-control" id="startloc" data-ng-model="customerseatbooking.startloc" style="width:200px" data-ng-blur="custvalidation('startloc',customerseatbooking.startloc)">
				    </div>
				  </td>
				  <td style="width:10%">
				   <div class="form-group">
				      <label for="endloc">End Location</label>
				      <input type="text" class="form-control" id="endloc" data-ng-model="customerseatbooking.endloc" style="width:200px" data-ng-blur="custvalidation('endloc',customerseatbooking.endloc)">
				   </div>
				  </td>
				  <td style="width:10%">
				    <div class="form-group">
				      <label for="depdate" >Departure Date</label>
				      <input type="date" id="depdate" data-ng-model="customerseatbooking.depdate" class="form-control" style="width:200px" data-ng-blur="custvalidation('depdate',customerseatbooking.depdate)">
				    </div>
				  </td>
			  </tr>
		  </tbody>
	  </table>
  <br>
  <div class="d-flex justify-content-center">
  <button type="button" ng-click="custsubmit()" class="btn btn-success">Submit</button>
    &nbsp;
  <button type="button" ng-click="custreset()" class="btn btn-success">Reset</button>
  </div>
  </form>
 </div>
  <br>
  <div ng-show="available" class="container" style="background-color:#e7feff;">
  <h2 class="d-flex justify-content-center">Available Buses</h2>
  <br>
  <div ng-show="resplis.length==0">
  <h3 class="d-flex justify-content-center">No bus available at this moment</h3>
  <br><br>
  </div>
  <div ng-show="resplis.length>0">
	   <div data-ng-repeat="m in resplis" style="margin-left:10%">
	    <h1 data-ng-click="expandbus(m,'expand')" class="verticaldtls">{{m.busdetails.busname}} | {{m.startpoint}} -> {{m.endpoint}} | {{m.deptime}} - {{m.arrtime}} &nbsp;&nbsp;&nbsp;<i class="fa fa-angle-down" ng-show="!m.expansion"></i><i class="fa fa-angle-up" ng-show="m.expansion"></i></h1>
	    <div ng-show="m.expansion">
			<jsp:include page="busseatallocate.jsp" />
		</div> 
	   </div>
	   <br><br>
   </div>
  </div>
</div>