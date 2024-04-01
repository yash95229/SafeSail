package com.viewdata.portlet;

import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.safesail.model.LifeInsurance;
import com.safesail.model.LifeInsuranceTable;
import com.safesail.model.Policy;
import com.safesail.model.UserTable;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.PolicyLocalService;
import com.safesail.service.UserTableLocalService;
import com.viewdata.constants.ViewDataPortletKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ViewDataPortletKeys.VIEWDATA,
		"mvc.command.name=userCSVDataUpload" }, service = MVCActionCommand.class)
public class CsvUploadFileActionCommand extends BaseMVCActionCommand {

	Log log = LogFactoryUtil.getLog(CsvUploadFileActionCommand.class);

	@Reference
	LifeInsuranceLocalService lifeInsuranceLocalService;

	@Reference
	PolicyLocalService policyLocalService;

	@Reference
	UserTableLocalService userTableLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	 try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			File csvFile = uploadRequest.getFile("csvDataFile");
			log.info("CSV File ===> " + csvFile);
			JSONArray csvDataArray = JSONFactoryUtil.createJSONArray();
			if (Validator.isNotNull(csvFile)) {
				if (csvFile.getName().contains(".csv")) {
					try (InputStream targetStream = new FileInputStream(csvFile);
							InputStreamReader isr = new InputStreamReader(targetStream);) {

						CSVFormat csvFormat = CSVFormat.newFormat(',');
						CSVParser csvParser = csvFormat.parse(isr);
						if (csvParser != null) {
							JSONObject rowObject = null;
							for (CSVRecord record : csvParser) {
								rowObject = JSONFactoryUtil.createJSONObject();
								for (int j = 0; j < record.size(); j++) {
									rowObject.put(String.valueOf(j), record.get(j));
								}
								csvDataArray.put(rowObject);
							}
							log.info("CSV Data : " + csvDataArray.toString());
						}

					} catch (IOException e) {
						log.error("Exception while reading file : ", e);
						throw e;
					}
				} else {
					log.error("Uploaded File is not CSV file.Your file name is ----> ");
				}

			}

			for (int i = 1; i < csvDataArray.length(); i++) {
				JSONObject csvData = csvDataArray.getJSONObject(i);
				SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
				String date = csvData.getString("2");
				String result = date.replaceAll("^\"|\"$", "");
				Date dob = dateFormatter.parse(result);
				if (!(findbyquoteId(csvData.getString("0").replaceAll("^\"|\"$", "")))) {
					LifeInsurance lastData = lifeInsuranceLocalService.addReg(
							csvData.getString("0").replaceAll("^\"|\"$", ""),
							csvData.getString("1").replaceAll("^\"|\"$", ""),
							csvData.getString("5").replaceAll("^\"|\"$", ""),
							Long.parseLong(csvData.getString("4").replaceAll("^\"|\"$", "")),
							csvData.getString("8").replaceAll("^\"|\"$", ""),
							csvData.getString("7").replaceAll("^\"|\"$", ""), dob,
							csvData.getString("3").replaceAll("^\"|\"$", ""),
							Boolean.parseBoolean(csvData.getString("19").replaceAll("^\"|\"$", "")),
							Long.parseLong(csvData.getString("9").replaceAll("^\"|\"$", "")),
							Long.parseLong(csvData.getString("20").replaceAll("^\"|\"$", "")),
							csvData.getString("6").replaceAll("^\"|\"$", ""),
							Integer.parseInt(csvData.getString("10").replaceAll("^\"|\"$", "")),
							Integer.parseInt(csvData.getString("11").replaceAll("^\"|\"$", "")),
							csvData.getString("12").replaceAll("^\"|\"$", ""),
							csvData.getString("13").replaceAll("^\"|\"$", ""),
							Integer.parseInt(csvData.getString("14").replaceAll("^\"|\"$", "")),
							Integer.parseInt(csvData.getString("15").replaceAll("^\"|\"$", "")),
							Integer.parseInt(csvData.getString("16").replaceAll("^\"|\"$", "")),
							Long.parseLong(csvData.getString("17").replaceAll("^\"|\"$", "")),
							Long.parseLong(csvData.getString("18").replaceAll("^\"|\"$", "")));

					Policy policy = policyLocalService.addPolicy(
							Long.parseLong(csvData.getString("21").replaceAll("^\"|\"$", "")),
							Long.parseLong(csvData.getString("22").replaceAll("^\"|\"$", "")),
							Long.parseLong(csvData.getString("20").replaceAll("^\"|\"$", "")),
							csvData.getString("1").replaceAll("^\"|\"$", ""),
							csvData.getString("23").replaceAll("^\"|\"$", ""),
							csvData.getString("8").replaceAll("^\"|\"$", ""),
							Long.parseLong(csvData.getString("9").replaceAll("^\"|\"$", "")),
							Integer.parseInt(csvData.getString("11").replaceAll("^\"|\"$", "")),
							csvData.getString("12").replaceAll("^\"|\"$", ""),
							Long.parseLong(csvData.getString("27").replaceAll("^\"|\"$", "")),
							csvData.getString("0").replaceAll("^\"|\"$", ""),
							Integer.parseInt(csvData.getString("28").replaceAll("^\"|\"$", "")),i);

					UserTable user = userTableLocalService.addUser(csvData.getString("0").replaceAll("^\"|\"$", ""),
							Long.parseLong(csvData.getString("17").replaceAll("^\"|\"$", "")),
							csvData.getString("29").replaceAll("^\"|\"$", ""));
				}

			}

		} catch (Exception e) {
			log.error("Exception in CSV File Reading Process :: ", e);
		}
	}

	public boolean findbyquoteId(String quoteId) {

		DSLQuery dslQuery = DSLQueryFactoryUtil.select(LifeInsuranceTable.INSTANCE.quoteId)
				.from(LifeInsuranceTable.INSTANCE);
		List<String> quoteIds = lifeInsuranceLocalService.dslQuery(dslQuery);
		if (quoteIds.contains(quoteId)) {
			return true;
		}

		return false;
	}

}
