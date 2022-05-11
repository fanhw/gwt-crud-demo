package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.view.client.ListDataProvider;

import java.util.Date;
import java.util.List;


/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-06 20:12
 */

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {
    /**
     * PRC service.
     */
    private final ObtainServiceAsync personService = GWT.create(ObtainService.class);

    /**
     * Dialog field - username.
     */
    private final TextBox username = new TextBox();

    /**
     * Dialog field - birthday.
     */
    private final DateBox birthday = new DateBox();

    //  private final DatePicker birthday = new DatePicker();

    private final TextBox age = new TextBox();

    private final TextBox jobNumber = new TextBox();
    /**
     * Field contains id.
     */
    private Long id = -1L;

    private static final long ID_INITVALUE = -1L;

    /**
     * Create table with dynamic loading data
     *
     * @param table base widget.
     * @return data provider.
     */
    private ListDataProvider<DoctorDTO> createTable(CellTable<DoctorDTO> table) {
        TextColumn<DoctorDTO> nameColumn = new TextColumn<DoctorDTO>() {
            @Override
            public String getValue(DoctorDTO doctorDTO) {
                return doctorDTO.getName();
            }
        };
        TextColumn<DoctorDTO> ageColumn = new TextColumn<DoctorDTO>() {
            @Override
            public String getValue(DoctorDTO doctorDTO) {
                return String.valueOf(doctorDTO.getAge());
            }
        };
        TextColumn<DoctorDTO> birthColumn = new TextColumn<DoctorDTO>() {
            @Override
            public String getValue(DoctorDTO doctorDTO) {
                return doctorDTO.getBirthStr();
            }
        };
        TextColumn<DoctorDTO> jobNumberColumn = new TextColumn<DoctorDTO>() {
            @Override
            public String getValue(DoctorDTO doctorDTO) {
                return doctorDTO.getJobNumber();
            }
        };
        table.addColumn(nameColumn, "Username");
        table.addColumn(ageColumn, "Age");
        table.addColumn(birthColumn, "Birthday");
        table.addColumn(jobNumberColumn, "JobNumber");
        ListDataProvider<DoctorDTO> dataProvider = new ListDataProvider<DoctorDTO>();
        dataProvider.addDataDisplay(table);
        this.personService.list(new AsyncCallback<List<DoctorDTO>>() {
            @Override
            public void onFailure(Throwable throwable) {
                GWT.log("error", throwable);
                Window.alert("error01");
            }

            @Override
            public void onSuccess(List<DoctorDTO> people) {
                dataProvider.getList().addAll(people);
            }
        });
        return dataProvider;
    }

    private void showTableByConditionSearch(ListDataProvider<DoctorDTO> dataProvider, TextBox textBox) {
        personService.getDoctorListByIdOrName(textBox.getValue(), new AsyncCallback<List<DoctorDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                GWT.log("error", caught);
                Window.alert("error03");
            }

            @Override
            public void onSuccess(List<DoctorDTO> result) {
                dataProvider.getList().addAll(result);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onModuleLoad() {
        CellTable<DoctorDTO> table = new CellTable<DoctorDTO>();
        DateTimeFormat dateFormat = DateTimeFormat.getFormat("yyyy-MM-dd");
        birthday.setFormat(new DateBox.DefaultFormat(dateFormat));
        ListDataProvider<DoctorDTO> dataProvider = createTable(table);
        DialogBox dialog = editDialog();
        Label label = new Label("根据名字模糊查询或工号精确匹配,按检索按钮");
        TextBox textBox = new TextBox();
        Button button = new Button("检索");
        button.addClickHandler(event -> {
            dataProvider.getList().clear();
            showTableByConditionSearch(dataProvider, textBox);
        });
        Button button01 = new Button("重置");
        button01.addClickHandler(event -> {
            textBox.setValue("");
            Window.Location.reload();
        });
        Button add = new Button("Add", new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                username.setValue("");
                birthday.setValue(new Date());
                age.setValue("");
                jobNumber.setValue("");
                id = -1L;
                dialog.center();
                dialog.show();
            }
        });
        Button edit = new Button("Edit", new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                DoctorDTO doctorDTO = dataProvider.getList().get(table.getKeyboardSelectedRow());
                //Window.alert(String.valueOf(table.getKeyboardSelectedRow()));
                username.setValue(doctorDTO.getName());
                birthday.setValue(doctorDTO.getBirthday());
                age.setValue(String.valueOf(doctorDTO.getAge()));
                id = doctorDTO.getId();
                jobNumber.setValue(doctorDTO.getJobNumber());
                dialog.show();
                dialog.center();
            }
        });
        Button delete = new Button("Delete", new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                final int index = table.getKeyboardSelectedRow();
                DoctorDTO person = dataProvider.getList().get(index);
                personService.delete(person, new AsyncCallback<Boolean>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        GWT.log("error", throwable);
                    }

                    @Override
                    public void onSuccess(Boolean aBoolean) {
                        dataProvider.getList().remove(index);
                    }
                });
            }
        });
        HorizontalPanel control = new HorizontalPanel();
        control.add(add);
        control.add(edit);
        control.add(delete);
        Label tipsLabel = new Label("编辑或删除请勾选记录，默认为第一条");
        label.setWidth("200px");
        control.add(tipsLabel);
        HorizontalPanel select = new HorizontalPanel();
        select.add(label);
        select.add(textBox);
        select.add(button);
        select.add(button01);
        VerticalPanel panel = new VerticalPanel();
        panel.add(control);
        panel.add(select);
        panel.add(table);
        RootPanel.get("aaa").add(panel);
    }
//     private DialogBox tipsDialog(){
//        final DialogBox dialogBox = new DialogBox();
//        dialogBox.setText("explanation");
//        dialogBox.setAnimationEnabled(true);
//        HorizontalPanel horizontalPanel = new HorizontalPanel();
//        Label label = new Label("编辑或删除请勾选记录，默认为第一条");
//        label.setWidth("200px");
//        horizontalPanel.add(label);
//        dialogBox.setWidget(horizontalPanel);
//        return dialogBox;
//    }

    /**
     * Create dialog.
     *
     * @param
     * @return dialog box.
     */
    private DialogBox editDialog() {
        final DialogBox dialogBox = new DialogBox();
        dialogBox.setText("handle");
        dialogBox.setAnimationEnabled(true);

        VerticalPanel dpanel = new VerticalPanel();
        HorizontalPanel usernamePanel = new HorizontalPanel();
        Label label = new Label("Username");
        label.setWidth("100px");
        usernamePanel.add(label);
        usernamePanel.add(username);
        dpanel.add(usernamePanel);

        HorizontalPanel dbirthdayPanel = new HorizontalPanel();
        label = new Label("Birthday");
        label.setWidth("100px");
        dbirthdayPanel.add(label);
        dbirthdayPanel.add(birthday);
        dpanel.add(dbirthdayPanel);
        HorizontalPanel agePanel = new HorizontalPanel();
        Label labelAge = new Label("Age");
        labelAge.setWidth("100px");
        agePanel.add(labelAge);
        agePanel.add(age);
        dpanel.add(agePanel);
        HorizontalPanel jobNumberPanel = new HorizontalPanel();
        Label labelJobNumber = new Label("JobNumber");
        labelJobNumber.setWidth("101px");
        jobNumberPanel.add(labelJobNumber);
        jobNumberPanel.add(jobNumber);
        dpanel.add(jobNumberPanel);
        HorizontalPanel dcontrol = new HorizontalPanel();
        dcontrol.add(new Button("Save", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                personService.add(new DoctorDTO(id, username.getValue(), Integer.parseInt(age.getValue()), birthday.getValue(), jobNumber.getValue()), new AsyncCallback<DoctorDTO>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        GWT.log("error", throwable);
                        Window.alert("error02");
                    }

                    @Override
                    public void onSuccess(DoctorDTO person) {
//                        if (!id.equals(ID_INITVALUE)) {
//                             dataProvider.getList().set(dataProvider.getList().indexOf(person), person);
//                        } else {
//                            dataProvider.getList().add(person);
//                        }
                        Window.Location.reload();
                        dialogBox.hide();
                    }
                });

            }
        }));
        dcontrol.add(new Button("Cancel", new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                dialogBox.hide();
            }
        }));
        dpanel.add(dcontrol);
        dialogBox.setWidget(dpanel);
        return dialogBox;
    }
}
