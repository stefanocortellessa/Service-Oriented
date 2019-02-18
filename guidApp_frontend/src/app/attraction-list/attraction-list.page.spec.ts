import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttractionListPage } from './attraction-list.page';

describe('AttractionListPage', () => {
  let component: AttractionListPage;
  let fixture: ComponentFixture<AttractionListPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttractionListPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttractionListPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
