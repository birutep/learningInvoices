package lt.invoices.invoiceApp.good;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="good")
@RequestMapping(value="/api/goods")
public class GoodController {

		@Autowired
		private GoodServices goodService;
		
		@RequestMapping(method=RequestMethod.GET)
		@ApiOperation(value="Get all goods", notes="Returns all goods in one invoice.")
		public List<GoodModel> getGoods(){
			return Collections.emptyList();
			//neuzmirsk pasikeisti i getAll metoda!
		}
		
		@RequestMapping(method=RequestMethod.POST)
		@ResponseStatus(HttpStatus.CREATED)
		@ApiOperation(value="Create good", notes="Creates new good - adds it to DB.")
		public void addGood(@RequestBody GoodModel good) {
			goodService.createGood(good);
		}	
		
		@RequestMapping(method=RequestMethod.DELETE)
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@ApiOperation(value="Delete good", notes="Deletes one good - removes it from DB.")
		public void deleteGood(@RequestBody GoodModel good) {
			goodService.deleteGood(good);
		}
}
